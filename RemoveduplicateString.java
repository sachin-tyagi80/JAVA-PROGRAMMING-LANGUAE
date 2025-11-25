public class RemoveduplicateString {
  public static void dulicate(String str,int idx, StringBuilder newStr,boolean map[] ){
    if(idx == str.length()){
      System.err.println(newStr);
      return;
    }

    // kaam
    char currChar = str.charAt(idx);
    if(map[currChar-'a'] == true){
      //duplicate
      dulicate(str, idx+1, newStr, map);
    }
    else{
      map[currChar-'a'] = true;
      dulicate(str, idx+1, newStr.append(currChar), map);
    }
  }

  public static void main(String[] args) {
    String str = "appnnacollege";
    dulicate(str, 0, new StringBuilder(""), new boolean[26]);
  }
  
}
