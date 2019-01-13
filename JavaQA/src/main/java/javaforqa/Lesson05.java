package javaforqa;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class Lesson05 {
/*
 * Viết class MyArray với các đặc điểm sau:
 * -Properties:
 *  + int[] Numbers - Lưu trữ một mảng các số nguyên 
 * -Methods:
 *  + MyArray(int[] numbers) - Khởi tạo mảng các số nguyên cho thuộc tính Numbers
 *  + CountNumber(int x) - Đêm số lần xuất hiện phần tử x trong mảng Numbers
 *  + RemoveDupplicateNumber() - Phương thức loại bỏ các phần tử trùng trong mảng Numbers
 *	Viết class Test kiểm thử cho method CountNumber, RemoveDupplicateNumber
 */
	class MyArray{
		public int[] Numbers;
		
		//Method
		public MyArray(int[] numbers)
		{
			this.Numbers = numbers;
		}
		
		public int CountNumber(int x)
		{
			int count=0;
			for(int number:this.Numbers)
			{
				if(number==x)
				{
					count++;
				}
			}
			return count;
		}
		
		public ArrayList<Integer> RemoveDupplicateNumber()
		{
			//Tạo ra một mảng lưu các phần từ không bị trùng
			ArrayList<Integer> arrMyNumber = new ArrayList<Integer>();
			
			//Lần lượt lặp các phần tử trong mảng
			for(int i=0; i< this.Numbers.length; i++)
			{
				boolean isDupplicate=false;
				int number = this.Numbers[i];
				for(int j=0; j< this.Numbers.length; j++)
				{
					int checkNumber = this.Numbers[j];
					if(number == checkNumber && i!=j)
					{
						isDupplicate=true;
						break;
					}
				}
				if(isDupplicate==false)
				{
					arrMyNumber.add(number);
				}
			}
			
			return arrMyNumber;
		}
	}
	
	//Test
	@Test
	public void Check_RemoveDupplicateNumber()
	{
		//Arrange
		int[] Numbers = {1,2,3,5,6,7,5};
		MyArray myArr = new MyArray(Numbers);
		//Action
		
		ArrayList<Integer> lstMyNumber = myArr.RemoveDupplicateNumber();
		/*
		//In ra để nhìn
		for(int n:lstMyNumber)
		{
			System.out.println(n);
		}
		*/
		Assert.assertEquals(5, lstMyNumber.size());
	}
	/*
	public Lesson05()
	{
		for (int i = 0; i < 20; i+=5) {
			
		}
		
		while(i<20)
		{
			//Làm gì thì làm đi
			
			//Phá vỡ
			i+=5;
		}
		
		while (Dkien_cua_viec_Lap) {
			//Hành động
			
			//Hoạt động phá vỡ đk lặp
		}
		
		do
		{
			//Thực hiện lặp khối lệnh ở đây
			//Khi đk trong mệnh while còn thỏa mãn
			
			//Phải có lệnh thay đổi giá đk lặp
		}
		while(đk_lặp)
			
		//For làm việc với array
		for(Object a: Bien_Mang)
		{
			//Đây là vòng lặp dùng để duyệt hết các phần tử
			// trong 1 array
			
			//Chú ý: chỉ làm việc với mảng
		}
	}*/
	@Test
	@Ignore
	public void Test_Lesson05() {
		int[] number = {1,3,5,6,7};
		/*
		for(int n:number)
		{
			System.out.println(n);
		}
		*/
		/*
		int i=0;
		while(i<number.length)
		{
			System.out.println(number[i]);
			
			i++;
		}
		*/
		
		int i=0;
		do
		{
			System.out.println(number[i]);
			i++;
		}
		while(i<number.length);
		
	}
}
