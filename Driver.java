public class Driver{
  public static void main(String[]args){
    QueenBoard b;
    int size = 4;
    try{
	b = new QueenBoard(size);
  	b.solve();
  	System.out.println(b);
    }catch(Exception e){
	System.out.println("Fail solve size "+size+" board, exception"+e);
    }


    try{
	b = new QueenBoard(size);
  	System.out.println(b.countSolutions());
    }catch(Exception e){
	System.out.println("Fail countsolutions size "+size+" board, exception"+e);
    }
    
  }
}
