package javaforqa;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class Lesson02 {
	/*
	 * Bài 01: Viết class MyNumber với các đặc điểm sau - Thuộc tính: int[]
	 * arrNumber - lưu trữ một mảng các số nguyên - Phương thức: + MyNumber(int[]
	 * numbers) - Khởi tạo giá trị cho mảng số nguyên arrNumber +
	 * PrintPrimeNumbers() - In cá số nguyên tố có trong mảng arrNumber ra màn hình
	 * + GetPrimeNumbers() - Trả ra một mảng các số nguyên tố từ mảng arrNumber
	 * 
	 * Bài 02: Viết Testmethod cho phương thức GetPrimeNumbers() ở bài 01
	 */

	class MyNumber {
		// Để khai báo một mảng, sử dụng quy tắc
		// <kiểu dữ liệu> [] tên_biến_mảng
		// cấp phát bộ nhớ cho mảng
		// tên_biến_mảng = new <kiểu dữ liệu> [<Số phần tử mảng>]

		public int[] arrNumber;

		private boolean IsPrime(int number) {
			boolean result = true;
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					result = false;
					break;
				}
			}

			return result;
		}

		// Phương thức
		public MyNumber(int[] numbers) {
			this.arrNumber = numbers;
		}

		// In số nguyên tố từ mảng
		public void PrintPrimeNumbers() {
			for (int i = 0; i < arrNumber.length; i++) {
				if (IsPrime(arrNumber[i])) {
					System.out.println(arrNumber[i]);
				}
			}
		}

		public ArrayList GetPrimeNumbers() {
			ArrayList lstPrimeNumber = new ArrayList();
			for (int i = 0; i < arrNumber.length; i++) {
				if (IsPrime(arrNumber[i])) {
					lstPrimeNumber.add(arrNumber[i]);
				}
			}

			return lstPrimeNumber;
		}
	}

	// Test PrintPrimeNumbers
	@Test
	public void Test_PrintPrimeNumbers() {
		// Arrange
		int[] numbers = new int[5];
		numbers[0] = 1;
		numbers[1] = 6;
		numbers[2] = 7;
		numbers[3] = 9;
		numbers[4] = 10;

		MyNumber myNum = new MyNumber(numbers);
		myNum.PrintPrimeNumbers();
	}

	@Test
	public void GetPrimeNumbers() {
		// Arrange
		int[] numbers = new int[6];
		numbers[0] = 1;
		numbers[1] = 6;
		numbers[2] = 7;
		numbers[3] = 9;
		numbers[4] = 11;
		numbers[5] = 15;

		MyNumber myNum = new MyNumber(numbers);
		ArrayList result = myNum.GetPrimeNumbers(); //unit - cách viết test như này gọi là unittest
		//Unit test đó là viết các testmethod kiểm tra xử lý của một method khác
		
		//Assert
		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals(result.get(0), 1);
		Assert.assertEquals(result.get(1), 7);
	}
}
