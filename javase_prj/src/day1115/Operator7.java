package day1115;
/*
	���Կ�����
	=,
	+=,-=,*=,/=,%=
	<<=,>>=,>>>=
	&=,|=,^=
*/



class Operator7{
	public static void main(String[] args) {
		int i=3;// ����
		//�������
		i+=2;//5
		i-=1; // 4
		i*=2; //8
		i/=3;//
		i%=3;

		//����Ʈ ����
		i<<=4; // i=i<<4;
		i>>=1; // i=i>>1;
//		System.out.println(i);//debug���� method ���߽� �� Ȯ�ο�
		//�������� �ڵ忡 ����ڵ尡 �����ϸ� �ӵ��� ��������.
		i>>>=2; 
		//��Ʈ��������
		i&=12;// i=i&12;//0100  & 1100 = 0100
		i|= 11; //i=i|11=1111;
		i^=5; // i=i^5// 1111^010= 1010
		System.out.println(i);

	}
}