public class DiagonalSum {
  public static int diagonalSum(int matrix[][]){
    int sum=0;
    int n= matrix.length;
    // for(int i=0;i<matrix.length;i++){ // O(n2)
    //   for(int j = 0;j<matrix[0].length;j++){
    //     if(i == j){
    //       sum += matrix[i][j];
    //     } 
    //     else if(i+j == matrix.length-1){
    //       sum += matrix[i][j];
    //     }
    //   }
    // }
    for(int i =0;i<n;i++){ //O(n)
      //pd
      sum += matrix[i][i];
      //sd
      sum += matrix[i][n-i-1];
    }
    return sum;
  }
  public static void main(StringDemo[] args) {
    int matrix[][] = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,16}};
  System.out.println(diagonalSum(matrix));
  }
  
}
