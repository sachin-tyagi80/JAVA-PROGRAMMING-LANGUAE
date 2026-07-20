import java.util.*;
public class Chocola {
  public static void main(String args[]){
    int n = 4, m = 6;
    Integer ver[] = {2,1,3,1,4}; // m-1 vertical cuts
    Integer hor[] = {4,1,2}; // n-1 horizontal cuts

    Arrays.sort(ver,Collections.reverseOrder());
    Arrays.sort(hor,Collections.reverseOrder());
    int h=0,v=0;
    int hp= 0, vp=0;
    int cost =0;
    while(h<hor.length && v<ver.length){
      if(hor[h]>=ver[v]){ //horizontal cut is more expensive than vertical cut
        cost += (hor[h]*vp); // horizontal cut cost is multiplied by the number of vertical pieces it will affect
        hp++;
        h++;
      }else{  // vertical cut is more expensive than horizontal cut
        cost += (ver[v]*hp); // vertical cut cost is multiplied by the number of horizontal pieces it will affect
        vp++;
        v++;
      }
    }

    while(h<hor.length){ // if there are still horizontal cuts left
      cost += (hor[h]*vp);
      h++;
      hp++;
    }

    while(v<ver.length){ // if there are still vertical cuts left
      cost += (ver[v]*hp);
      v++;
      vp++;
    }
    System.out.println("min cost of cuts = " + cost);
  }

  
}
