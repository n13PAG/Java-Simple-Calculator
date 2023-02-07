import java.util.ArrayList;

public abstract class Calculator {
    private int cacheCapcity;
    private ArrayList<Double> cachedResults;
    private int currentResultIndex;

    public double getLastResult(){
        if (cachedResults.size() == 0){
            return null;
        }
        currentResultIndex = cachedResults.size() - 1;
        return cachedResults.get(cachedResults.size() - 1);
    }

    public double cycleToPreviousResult(){
        currentResultIndex -= 1;
        if (currentResultIndex < 0){
            currentResultIndex = 0;
        }
        return cachedResults.get(currentResultIndex);
    }

    public double cycleToNextResult(){
        currentResultIndex += 1;
        if (currentResultIndex >= cachedResults.size()){
            return getLastResult()
        }
        return cachedResults.get(currentResultIndex);
    }

    public void clearCache(){
        cachedResults.clear();
    }

    public double makeTheOperationWithOldResult(result){
        // ?
    }

    public void storeResult(doube result){
        if (cachedResults.size() == cacheCapcity){
            cachedResults.remove(0);
        }
        cachedResults.add(r);
    }

    public void setResultCacheCapacity(cacheCapcity){
        this.cacheCapcity = cacheCapcity;
        cachedResults = new ArrayList<>(cacheCapcity);
        currentResultIndex = 0;
    }

}