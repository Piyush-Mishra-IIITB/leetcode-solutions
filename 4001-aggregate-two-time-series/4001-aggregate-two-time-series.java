class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int i=0;
        int j=0;
        List<List<Integer>>ll=new ArrayList<>();
        while(i<series1.length && j<series2.length){
            int ind1=series1[i][0];
            int val1=series1[i][1];
            int ind2=series2[j][0];
            int val2=series2[j][1];
            if(ind1==ind2){
                List<Integer>var=new ArrayList<>();
                var.add(ind1);
                var.add(val1+val2);
                ll.add(new ArrayList<>(var));
                i++;
                j++;
            }
            else if(ind1<ind2){
                List<Integer>var=new ArrayList<>();
                var.add(ind1);
                var.add(val1+val2);
                ll.add(new ArrayList<>(var));
                i++;
            }else{
                List<Integer>var=new ArrayList<>();
                var.add(ind2);
                var.add(val1+val2);
                ll.add(new ArrayList<>(var));
                j++;
            }
        }
        while(i<series1.length){
            int ind1=series1[i][0];
            int val1=series1[i][1];
             List<Integer>var=new ArrayList<>();
                var.add(ind1);
                var.add(val1);
                ll.add(new ArrayList<>(var));
                i++;
        }
        while(j<series2.length){
            int ind1=series2[j][0];
            int val1=series2[j][1];
             List<Integer>var=new ArrayList<>();
                var.add(ind1);
                var.add(val1);
                ll.add(new ArrayList<>(var));
                j++;
        }
        return ll;
    }
}