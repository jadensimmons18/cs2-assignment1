/*  Jaden Simmons
    Sensor Range
    COP3503 Computer Science 2
    SensorRange.java
 */






public class SensorRange {
    public static int[] rangeCountBF(int[] readings, int[][] queries){
        int numQueries = queries.length;
        int[] results = new int[numQueries];
        int queryResult = 0;
        int queryResultsIndex = 0;

        for (int i = 0; i < numQueries; i++){
            int L = queries[i][0];
            int H = queries[i][1];

            for (int j = 0; j < readings.length; j++){
                if (readings[j] < H && readings[j] > L){
                    queryResult++;
                }
            }
            results[queryResultsIndex] = queryResult;
            queryResultsIndex++;
        }

        return results;
    }

    // public static int[] rangeCountFast(int[] readings, int[][] queries){

    // }
}
