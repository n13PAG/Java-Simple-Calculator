import java.util.ArrayList;

public class Calculator {
    private int cacheCapacity;
    private ArrayList<Double> cachedResults;
    private int currentResultIndex;

    /* Returns previous calculated result or return 0 if there are
     no cached results */
    public double getLastResult(){
        if (cachedResults.size() == 0){
            return 0;
        }
        currentResultIndex = cachedResults.size() - 1;
        return cachedResults.get(cachedResults.size() - 1);
    }

    /* Cycles back by one index through the results cache and returns the
    * value found */
    public double cycleToPreviousResult(){
        currentResultIndex -= 1;
        if (currentResultIndex < 0){
            currentResultIndex = 0;
        }
        return cachedResults.get(currentResultIndex);
    }

    /* Cycles forward by one index through the results cache and returns
    * the value found */
    public double cycleToNextResult(){
        currentResultIndex += 1;
        if (currentResultIndex >= cachedResults.size()){
            return getLastResult();
        }
        return cachedResults.get(currentResultIndex);
    }

    public void clearCache(){
        cachedResults.clear();
    }

//    public double makeTheOperationWithOldResult(result){
//        // ?
//    }

    /* Adds result of calculation to the results cache. It removes the
    * first value in the cache before add the new result if the cache is full */
    public void storeResult(double result){
        if (cachedResults.size() == cacheCapacity){
            cachedResults.remove(0);
        }
        cachedResults.add(result);
    }

    /* Initializes the results cache and sets its capacity. Active index of
    * result cache is set */
    public void setResultCacheCapacity(int cacheCapacity){
        this.cacheCapacity = cacheCapacity;
        cachedResults = new ArrayList<>(cacheCapacity);
        currentResultIndex = 0;
    }

}