public class BuySell {
  public static int buyAndSellStocks(int prices[]){
    int buyPrices = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int i=0;i<prices.length;i++){
      if(buyPrices<prices[i]){
        int profit = prices[i] - buyPrices;//todays profit
        maxProfit = Math.max(maxProfit,profit);
      }else{
        buyPrices = prices[i];
      }
    }
    return maxProfit;
  }
  public static void main(StringDemo[] args) {
    int prices[] = {7,1,5,3,6,4};//o(n)
    System.out.println(buyAndSellStocks(prices));
  }
  
}
