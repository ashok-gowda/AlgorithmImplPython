import java.util.Hashtable;

/**
 * Created by ashokg on 11/3/17.
 */

class Position{
    int x;
    int y;
    Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class TripletsWithZeroSum {
    public static void main(String args[]){
        int arr[]={0, -1, 2, -3, 1};
        Hashtable<Integer,Position> hashObject=new Hashtable<Integer,Position>(25);
        for(int i=0;i<arr.length;i++)
            for (int j = i + 1; j < arr.length; j++)
                hashObject.put(arr[i] + arr[j], new Position(i, j));
        for(int i=0;i<arr.length;i++){
            if(hashObject.get(0-arr[i])!=null){
                Position p=hashObject.get(0-arr[i]);
                System.out.println(arr[p.x]+" "+arr[p.y]+" "+ arr[i]);
            }
        }

    }
}
