import java.util.*; 
public class JobSequencing {
  static class Job{
    int deadline;
    int profit;
    int id;

    public Job(int i,int d,int p){
      id = i;
      deadline = d;
      profit = p;
    }
  }
  public static void main(String args[]){
    int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
    ArrayList<Job> jobs = new ArrayList<>();

    for(int i=0;i<jobsInfo.length;i++){
      jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
    }
    // lambda function
    Collections.sort(jobs,(a,b) -> b.profit-a.profit); // decending order of profit

    ArrayList<Integer> seq = new ArrayList<>();
    int time =0;
    for(int i =0;i<jobs.size();i++){
      Job curr = jobs.get(i);
      if(curr.deadline>time){
        seq.add(curr.id);
        time++;
      }

    }
    System.out.println("max jobs = " + seq.size());
    for(int i=0;i<seq.size();i++){
      System.out.print(seq.get(i)+" ");
    }
    System.out.println();
  }
  
}



// I first created a Job class to store the job ID, deadline, and profit. Then I sorted all jobs in descending order of profit because selecting
// higher-profit jobs first is a greedy strategy to maximize profit. While traversing the sorted jobs, I selected a job if its deadline allowed 
// it to fit into the current available time slot and stored the selected job IDs.
