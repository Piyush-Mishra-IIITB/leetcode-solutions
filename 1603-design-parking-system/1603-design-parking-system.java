class ParkingSystem {
    List<Integer>b;
    List<Integer>m;
    List<Integer>s;
    int bs;
    int ms;
    int ss;
    public ParkingSystem(int big, int medium, int small) {
        bs=big;
        ms=medium;
        ss=small;
        b=new LinkedList<>();
        m=new LinkedList<>();
        s=new LinkedList<>();
    }
    public boolean addCar(int carType) {

         if(carType==1){
            if(b.size()==bs){
                return false;
            }
            b.add(1);
            return true;
         }
         if(carType==2){
            if(m.size()==ms){
                return false;
            }
            m.add(1);
            return true;
         }
         if(carType==3){
            if(s.size()==ss){
                return false;
            }
            s.add(1);
            return true;
         }
         return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */