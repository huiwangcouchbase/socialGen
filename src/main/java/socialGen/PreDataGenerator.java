/*
 * Copyright by The Regents of the University of California
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License from
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package socialGen;

import java.util.ArrayList;
import java.io.File;
import conf.Configuration;
import conf.SourcePartition;

public class PreDataGenerator {

    private static Configuration configuration;

    public static void main(String args[]) throws Exception {
        if (args.length < 1) {
            printUsage();
            System.exit(1);
        } else if (args[0].equals("-a")) {
            String rootPath = (new File(args[1])).getPath();
            long users = Long.valueOf(args[2]);
            int partitions = Integer.valueOf(args[3]);
            int clientNum = Integer.valueOf(args[4]);
            String partitionFilePath = (new File(args[5])).getAbsolutePath();
            System.out.println(partitionFilePath);
            long gbUsers = users;
            long chirpUsers = users;
            int avgGBMsgPerUser = 5;
            int avgChirpMsgPerUser = 10;
            long idsPerTable = 2 * avgChirpMsgPerUser * chirpUsers;
            long idsPerClient = 4 * idsPerTable;
            ArrayList<SourcePartition> partitionList = new ArrayList<SourcePartition>();
            for (int i = 1; i <= partitions; i++) {
                partitionList.add(new SourcePartition(
                        (long)i,
                        "localhost",
                        partitionFilePath + "/" + String.format("p%d", i)
                        ));
            }
            configuration = new Configuration(
                    0,
                    clientNum * idsPerClient + 1,
                    clientNum * idsPerClient + 1 * idsPerTable + 1,
                    users,
                    clientNum * idsPerClient + 2 * idsPerTable + 1,
                    clientNum * idsPerClient + 3 * idsPerTable + 1,
                    users,
                    avgGBMsgPerUser,
                    avgChirpMsgPerUser,
                    partitionList);
            XMLUtil.createTargetConfiguration(configuration);
            String outputConf = rootPath + "/output/partition-conf.xml";
            XMLUtil.writeToXML(configuration, outputConf);
            String outputPartitionInfo = rootPath + "/output/partitions";
            XMLUtil.writePartitionInfo(configuration, outputPartitionInfo);
        } else {
            String inputConf = args[0] + "/conf/conf.xml";
            configuration = XMLUtil.getConfiguration(inputConf);
            String outputConf = args[0] + "/output/partition-conf.xml";
            XMLUtil.writeToXML(configuration, outputConf);
            String outputPartitionInfo = args[0] + "/output/partitions";
            XMLUtil.writePartitionInfo(configuration, outputPartitionInfo);
        }
    }

    private static void printUsage() {
        System.out.println(" Invalid number of arguments!");
        System.out.println(" Usage: " + "PreDataGenerator <path of root path>");
        System.out.println(" Usage: " + "PreDataGenerator -a <path of root path> <user doc number> <partition number> <client#> <partition file path>");
    }
}
