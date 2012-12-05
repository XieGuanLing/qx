import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
*
�޸���־
1.�������װΪ����
2.ȥ��printRoundTime���������ж����realSize;
3.ThreadArray���밴����ʱ����С��������
**/

public class Fcfs {
	public static void main(String[] args) {
         ThreadArray tArray = new ThreadArray();
         int threadNumber = 0;
         
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("�����������Ŀ��");
         try {
			threadNumber = Integer.parseInt(stdin.readLine());
			
			for(int i=0; i<threadNumber; i++){
				System.out.println("���������["+i+"]����ʱ�䣺");
				float comeTime = Float.parseFloat(stdin.readLine());
				System.out.println("���������["+i+"]��Ҫcpu�ķ���ʱ��");
				float serverTime = Float.parseFloat(stdin.readLine());
				MyThread  thread = new MyThread(comeTime,serverTime);
		        tArray.addQueue(thread);
		        
		        
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tArray.bubbleSort();
		 System.out.println("-------------------------------FCFS-------------------------------");
		tArray.printRoundTime();
         
         
	}

}
class ThreadArray {
	int Maxsize = 10;
	MyThread [] AQueue = new MyThread[Maxsize];//������������
	int realSize = -1;  
	 
	public void addQueue(MyThread thread){
		if(realSize >= Maxsize){
			System.out.println("the queue is full");
		}else{
			realSize++;                  
			AQueue[realSize] = thread;
		}
	}
	 //���ݵ���ʱ����С��������
		public void bubbleSort(){
//System.out.println("bubble");
		int i, j, k=0;         //ѭ����������
		boolean change;      //�����Ƿ��б仯
		MyThread temp;             //�����ݴ����
		
		for(j=realSize; j>=1; j--){    
//System.out.println("go");ע��i,j ����  �Ⱥţ�
			change = false;
			for(i=0; i<=j-1; i++){
//System.out.println("go2");
				if(AQueue[i+1].comeTime < AQueue[i].comeTime){   
					temp = AQueue[i];
					AQueue[i] = AQueue[i+1] ;
					AQueue[i+1] = temp;
					change = true;
					
				}
			}
			if(change){
				k++;
				System.out.println("--------------�Ѿ����ݵ���ʱ����С������������--"+k+"--");
			}
		}
	}
	/**
	 * �ӽ����ύ��������ɵ�ʱ����Ϊ��תʱ��.
	 * Ҳ���ǵȴ������ڴ��ʱ��,�ھ��������еȴ���ʱ��,�� CPU��ִ�е�ʱ���I/O������ʱ����ܺ�.
	 * 
	 * ����ʵ���������תʱ��=���������еȴ���ʱ�� + �� CPU��ִ�е�ʱ��;
	 * @param realSize
	 */
	public void printRoundTime(){
		AQueue[0].finishTime = AQueue[0].comeTime + AQueue[0].serverTime;
		AQueue[0].roundTime = AQueue[0].finishTime ;
		print(0);
		for(int i=1; i<=realSize; i++){
			if(AQueue[i].comeTime > AQueue[i-1].finishTime){
				AQueue[i].finishTime = AQueue[i].comeTime + AQueue[i].serverTime;
				AQueue[i].roundTime = AQueue[i].serverTime;
				print(i);
			}else{
				AQueue[i].finishTime = AQueue[i-1].finishTime + AQueue[i].serverTime;
				AQueue[i].roundTime = AQueue[i].finishTime - AQueue[i].comeTime;
				print(i);
			}
		}
	}
	public void print(int i){
		System.out.println("����["+i+"]��ʼʱ��"+AQueue[i].comeTime +"���ʱ��:"+AQueue[i].finishTime +"��תʱ��:"
			      +AQueue[i].roundTime +"��Ȩ��תʱ��:"+(float)(AQueue[i].roundTime/AQueue[i].serverTime));
	}
}
class MyThread{
	float comeTime;
	float serverTime;
	float finishTime;
	float roundTime;
	
	MyThread(float comeTime,float serverTime){
		this.comeTime = comeTime;
		this.serverTime = serverTime;
	}
}











