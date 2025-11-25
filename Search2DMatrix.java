public class Search2DMatrix {
  public static boolean SearchMarix(int matrix[][],int key){
    int i = 0,j = matrix[0].length-1; // (0,m-1) cell
    while(i < matrix.length && j>=0){
      if(matrix[i][j] == key){
        return true;
      }
      else if(key < matrix[i][j]){
        j--; // left
      }
      else{
        i++; // bottom
      }
    }
    return false;
  }
  //   int i = matrix[0].length-1,j = 0; // (0,n-1) cell
  //   while(i < 0 && j>=matrix[0].length){
  //     if(matrix[i][j] == key){
  //       return true;
  //     }
  //     else if(key < matrix[i][j]){
  //       j++; // left
  //     }
  //     else{
  //       i--; // bottom
  //     }
  //   }
  //   return false;
  // }
  public static void main(StringDemo[] args) {
    int matrix[][] = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,16}};
    int key = 5;
    System.out.println(SearchMarix(matrix, key));
  }
  
}
