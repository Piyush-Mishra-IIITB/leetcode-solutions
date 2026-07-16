
class UndergroundSystem {
    class Pair1 {
        int totalTime;
        int totalPeople;
        Pair1(int totalTime, int totalPeople) {
            this.totalTime = totalTime;
            this.totalPeople = totalPeople;
        }
    }
    class Pair2 {
        String start;
        int time;
        Pair2(String start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    HashMap<Integer, Pair2> hm2;
    HashMap<String, Pair1> hm1;
    public UndergroundSystem() {
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        hm2.put(id, new Pair2(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        Pair2 curr = hm2.get(id);
        String route = curr.start + "#" + stationName;
        int travelTime = t - curr.time;
        if (hm1.containsKey(route)) {
            Pair1 p = hm1.get(route);
            p.totalTime += travelTime;
            p.totalPeople++;
        } else {
            hm1.put(route, new Pair1(travelTime, 1));
        }
        hm2.remove(id);
    }
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;
        Pair1 p = hm1.get(route);
        return (double) p.totalTime / p.totalPeople;
    }
}