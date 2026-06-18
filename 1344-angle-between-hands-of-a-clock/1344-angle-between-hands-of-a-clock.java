class Solution {
    public double angleClock(int hour, int minutes) {
       
      double hm = (hour % 12) * 30 + minutes * 0.5;
      double mm = minutes * 6;

      double diff = Math.abs(mm - hm);

return (diff > 180) ? 360 - diff : diff;

    }
}