/*  Jaden Simmons
    Sensor Range
    COP3503 Computer Science 2
    SensorRange.java
 */

import java.util.Arrays;

public class SensorRange 
{
    
    // Brute force approach that returns the query results in O(nq)
    public static int[] rangeCountBF(int[] readings, int[][] queries)
    {
        int numQueries = queries.length;
        int[] results = new int[numQueries];
        int queryResult = 0;
        int queryResultsIndex = 0;

        for (int i = 0; i < numQueries; i++)
        {
            int L = queries[i][0];
            int H = queries[i][1];

            for (int j = 0; j < readings.length; j++)
            {
                if (readings[j] <= H && readings[j] >= L)
                {
                    queryResult++;
                }
            }
            results[queryResultsIndex] = queryResult;
            queryResultsIndex++;
            queryResult = 0; // reset counter
        }

        return results;
    }

    // Uses binary search to find L in O(logn)
    static int findL(int[] arr, int target) 
    {
        int left = 0;
        int right = arr.length;

        while (left < right) 
        {
            int mid = (left + right) / 2;

            if (arr[mid] < target) 
            {
                left = mid + 1;  
            } else 
            {
                right = mid;
            }
        }

        return left;
    }

    // Finds the index of H in O(logn)
    static int findH(int[] arr, int target) 
    {
        int left = 0;
        int right = arr.length;

        while (left < right) 
        {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) 
            {
                left = mid + 1;  
            } else 
            {
                right = mid;
            }
        }

        return left;
    }

    // Returns query result array in O(nlogn + qlogn)
    public static int[] rangeCountFast(int[] readings, int[][] queries)
    {
        // Sort the readings in O(nlogn)
        Arrays.sort(readings);

        int[] results = new int[queries.length];
        int arrIndex = 0;

        // loops through queries and returns the result for each query into an array in O(qlogn)
        for (int i = 0; i < queries.length; i++)
        {
            int L = findL(readings, queries[i][0]);
            int H = findH(readings, queries[i][1]);
            int result = H - L;
            results[arrIndex++] = result;
        }

        return results;

    }


}
