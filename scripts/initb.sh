DATAPATH=$1
shift
PARTITIONS=$1
shift
CLIENTN=$1
shift
USERDOCS=$1
shift

mkdir -p "$PWD/output"

java -cp "$PWD/target/SocialGen.jar" socialGen.PreDataGenerator -a "$PWD" $USERDOCS $PARTITIONS $CLIENTN $DATAPATH

for i in `cat $PWD/output/partitions`
do
   PARTITION=`echo $i |cut -d ':' -f2`
   java -Xms1g -Xmx2g -cp "$PWD/target/SocialGen.jar" socialGen.DataGenerator "$PWD" $PARTITION $@ &
   pids+=($!)
done

echo "waiting processes"

result=0
for pid in "${pids[@]}"; do
   wait "$pid"
   if [ $? -eq 0 ]
   then
      echo "it worked"
   else
      echo "it failed"
      result=1
   fi
done

echo "finish waiting processes"

exit $result
