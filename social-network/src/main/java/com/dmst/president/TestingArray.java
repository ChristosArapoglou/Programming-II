
public class TestingArray{

    public static int arraytest(String objectarray[]){
        int k=0;
        for(int j=0; j<=7; j++){
            if(objectarray[j].isEmpty()){
                k++;
            }
        }
        return k;
    }
}