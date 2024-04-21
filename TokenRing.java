import java.util.*;

public class TokenRing{
	private int n;
	private int[] state;
	private boolean token;
	
	public TokenRing(int n){
		this.n=n;
		state=new int[n];
	}
	
	public void run(){
		for(int i=0;i<n;i++){
			state[i]=0;
		}
		int curr=new Random().nextInt(n);
		token=true;
		while(true){
			if(token){
				if(state[curr] == 0){
					enterCritical(curr);
					state[curr]=1;
				}
				else{
					exitCritical(curr);
					state[curr]=0;
					curr=(curr+1)%n;
					token=true;	
				}
			}
		}
	}
	
	private void enterCritical(int id){
		System.out.println("process "+id+ "entered critical section");
	}
	private void exitCritical(int id){
		System.out.println("process "+id+ "exited critical section");
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of processes :");
		int n=sc.nextInt();
		sc.close();
		TokenRing tr=new TokenRing(n);
		tr.run();
	}
	
}





