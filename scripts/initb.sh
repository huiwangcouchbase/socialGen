PARTITIONS=$1
shift
CLIENTN=$1
shift
USERDOCS=$1
shift

mkdir -p "$PWD/output"

java -cp "$PWD/target/SocialGen.jar" socialGen.PreDataGenerator -a "$PWD" $USERDOCS $PARTITIONS $CLIENTN "$PWD/bigfundata"

for i in `cat $PWD/output/partitions`
do
   PARTITION=`echo $i |cut -d ':' -f2`
   java -Xms1g -Xmx2g -cp "$PWD/target/SocialGen.jar" socialGen.DataGenerator "$PWD" $PARTITION $@
done
