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
package conf;

public class TargetPartition {

    private final long id;
    private final String host;
    private final String path;
    private final long globalStartIdOfGBookUsers;
    private final long gBookUserKeyMin;
    private final long gBookUserKeyMax;
    private final long globalStartIdOfChirpUsers;
    private final long chirpUserKeyMin;
    private final long chirpUserKeyMax;
    private final long globalStartIdOfGBookMessages;
    private final long gBookMsgIdMin;
    private final long gBookMsgIdMax;
    private final long globalStartIdOfChirpMessages;
    private final long chirpMsgIdMin;
    private final long chirpMsgIdMax;
    private final int avgMsgPerGBookUser;
    private final int avgMsgPerChirpUser;
    private final long seed;

    public TargetPartition(long id, String host, String path,
                           long globalStartIdOfGBookUsers, long gBookUserKeyMin, long gBookUserKeyMax,
                           long globalStartIdOfChirpUsers, long chirpUserKeyMin, long chirpUserKeyMax,
                           long globalStartIdOfGBookMessages, long gBookMsgIdMin, long gBookMsgIdMax,
                           long globalStartIdOfChirpMessages, long chirpMsgIdMin, long chirpMsgIdMax,
                           int avgMsgPerGBookUser, int avgChirpMsgPerUser, long seed) {
        this.id = id;
        this.host = host;
        this.path = path;
        this.globalStartIdOfGBookUsers = globalStartIdOfGBookUsers;
        this.gBookUserKeyMin = gBookUserKeyMin;
        this.gBookUserKeyMax = gBookUserKeyMax;
        this.globalStartIdOfChirpUsers = globalStartIdOfChirpUsers;
        this.chirpUserKeyMin = chirpUserKeyMin;
        this.chirpUserKeyMax = chirpUserKeyMax;
        this.globalStartIdOfChirpMessages = globalStartIdOfChirpMessages;
        this.chirpMsgIdMin = chirpMsgIdMin;
        this.chirpMsgIdMax = chirpMsgIdMax;
        this.globalStartIdOfGBookMessages = globalStartIdOfGBookMessages;
        this.gBookMsgIdMin = gBookMsgIdMin;
        this.gBookMsgIdMax = gBookMsgIdMax;
        this.avgMsgPerGBookUser = avgMsgPerGBookUser;
        this.avgMsgPerChirpUser = avgChirpMsgPerUser;
        this.seed = seed;
    }

    public long getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public long getGlobalStartIdOfGBookUsers() { return globalStartIdOfGBookUsers; }

    public long getgBookUserKeyMin() {
        return gBookUserKeyMin;
    }

    public long getgBookUserKeyMax() {
        return gBookUserKeyMax;
    }

    public long getGlobalStartIdOfChirpUsers() { return globalStartIdOfChirpUsers; }

    public long getChirpUserKeyMin() {
        return chirpUserKeyMin;
    }

    public long getChirpUserKeyMax() {
        return chirpUserKeyMax;
    }

    public long getGlobalStartIdOfGBookMessages() { return globalStartIdOfGBookMessages; }

    public long getGBookMsgIdMin() {
        return gBookMsgIdMin;
    }

    public long getGBookMsgIdMax() {
        return gBookMsgIdMax;
    }

    public long getGlobalStartIdOfChirpMessages() { return globalStartIdOfChirpMessages; }

    public long getChirpMsgIdMin() {
        return chirpMsgIdMin;
    }

    public long getChirpMsgIdMax() {
        return chirpMsgIdMax;
    }

    public int getAvgMsgPerGBookUser() {
        return avgMsgPerGBookUser;
    }

    public int getAvgMsgPerChirpUser() {
        return avgMsgPerChirpUser;
    }

    public String getPath() {
        return path;
    }

    public long getSeed() {
        return seed;
    }
}