package ListeSinifiYapmak;

public class MyList<T>{
    private int capacity = 10;
    private T[] array;
    public static int arrayIndex = 0;

    public MyList(int capacity) {
        this.createdArray(capacity);
    }

    public MyList() {
        this.createdArray(this.capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size(){
        return arrayIndex;
    }

    public void add(T data){
        if(this.arrayIndex < this.getCapacity()-1){
            this.array[arrayIndex] = data;
            arrayIndex++;
        }else {
            this.capacity *=2;
            createdArray(this.getCapacity());
            this.array[arrayIndex] = data;
            arrayIndex++;
        }
    }

    public void createdArray(int capacity){
        while (capacity > this.capacity){
            this.capacity *=2;
        }
        // T[] tempArray = new T[this.capacity]; // error :generic array creation
        T[] tempArray = (T[])new Object[this.capacity]; // simple and dangerous

        for(int i=0; i<capacity; i++){
            if(this.array == null){
                break;
            }
            if(this.array[i] == null){
                break;
            } else{
                tempArray[i] = this.array[i];
            }
        }
        this.array = tempArray;
    }

    public T get(int index){
        if(index > arrayIndex){
            return null;
        }else {
            return array[index];
        }
    }

    public T remove(int index){
        if(index > arrayIndex || this.array == null){
            return null;
        }else {
            T removeData = array[index];
            for(int i=index; i<arrayIndex; i++){
                if(this.array[i+1] == null){
                    this.array[i] = null;
                    break;
                } else{
                    this.array[i] = this.array[i+1];
                }
            }
            arrayIndex--;
            System.out.print("Veri başarılı bir şekilde silindi :");
            return removeData;
        }
    }
    public T set(int index, T data){
        if(index > arrayIndex){
            return null;
        }else {
            System.out.print(array[index] + " Yerine eklenen veri :");
            this.array[index] = data;
        }
        return data;
    }
    @Override
    public String toString(){
        String str ="[";
        for(int i = 0; i<this.array.length; i++){
            if(this.array[i+1] == null){
                str += this.array[i] + "]";
                break;
            }
            else {
                str += this.array[i] + ",";
            }
        }

        return str;
    }

    public int indexOfData(T data){
        for(int i = 0; i<this.array.length; i++){
            if(this.array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i = this.array.length-1; i>=0; i--){
            if(this.array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(arrayIndex == 0){
            return true;
        }
        return false;
    }

    public T[] toArray(){
        T[] tempArray = (T[])new Object[this.arrayIndex];
        for(int i = 0; i<arrayIndex; i++){
            tempArray[i] = this.array[i];
        }
        this.array = tempArray;
        return this.array;
    }

    public void clear(){
        T[] tempArray = (T[])new Object[this.capacity];
        this.array = tempArray;
        this.arrayIndex = 0;
    }

    public MyList<T> sublist(int start, int finish){
        int subCapacity = finish-start+1;
        MyList<T> sub =new MyList<>(subCapacity);
        for(int i = start; i<=finish; i++){
            sub.add(this.array[i]);
        }
        return sub;
    }

    public boolean contains(T data){
        for(T t : this.array){
            if(data == t){
                return true;
            }
        }
        return false;
    }
}
