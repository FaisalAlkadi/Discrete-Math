import java.math.BigInteger;

public class project {
private int d,y;

private boolean isPrime(int n) {
	if(n!=2)
    if (n%2==0) 
    	return false;
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0)
            return false;
    }
    return true;
}
private boolean isSquare(int n) {
	int a;
	a=(int) Math.sqrt(n);
	a=(int) Math.pow(a,2);
	if(n==a)
		return true;
	return false;
			
}
private int mod(int x, int y){
    int result = x % y;
    if (result < 0)
    {
        result += y;
    }
    return result;
}
BigInteger bi1, bi2, bi3;
void quadrtic(int a,int b,int c,int p){
	int Y;
	if(!isPrime(p)) {
		System.out.print("NO SOLUTION");
		return ;
	}
	if(a==0) {
		System.out.print("NO SOLUTION");
		return ;
	}
	int d=(int) Math.pow(b,2)-4*a*c;
	d=mod(d,p);
	y=(int) Math.pow(d,p-1)/2;
	if(y==mod(-1,p)) {
		System.out.print("NO SOLUTION");
		return ;
	}
	if(!isSquare(d)) {
		int f=d;
		for(int k=0;!isSquare(f);k++) {
			f=(int) Math.sqrt(d+p*k);
			if(isSquare(f))
				d=f;
		}
	}
	Y=mod(a*2,p);
	bi1 = new BigInteger(Integer.toString(Y));
	bi2 = new BigInteger(Integer.toString(p));
	bi3 = bi1.modInverse(bi2);
	String tt=bi3+"";
	Y=Integer.parseInt(tt);
	int x1,x2;
	x1=mod(-b,p)+d;
	x2=mod(-b,p)-d;
	x1=mod(x1*Y,p);
	x2=mod(x2*Y,p);
	
	System.out.print("{"+x1+","+x2+"}");
		
	
}
public static void main(String[] args) {
	project pr=new project();
	pr.quadrtic(15,19,6,11);
	
}


}
