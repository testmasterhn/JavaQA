package javaforqa;

import org.junit.Test;
import org.junit.Assert;

public class Lesson01 {
	/*
	 * Bài 01: Viết class MyNumber với các đặc tính sau: - Thuộc tính: int myNumber;
	 * - Method: + boolean IsPrime(int number) - Kiểm tra số number có phải là số
	 * nguyên tố + boolean IsPrime() - Kiểm tra số lưu trữ trong thuộc tính myNumber
	 * có phải là số nguyên tố + void PrintPrime() - Liệt kê toàn bộ số nguyên tố
	 * nhỏ hơn myNumber
	 * 
	 * Bài 02: Viết test method cho hàm IsPrime() ở trên
	 */

	class MyNumber {
		// Định nghĩa thuộc tính myNumber
		public int myNumber;

		public MyNumber()
		{
			
		}
		// Định nghĩa phương thức khởi tạo để khởi tạo giá trị cho thuộc tính
		public MyNumber(int inputNumber) {
			this.myNumber = inputNumber;
		}

		// Định nghĩa phương thức isPrime(int number)
		public boolean IsPrime(int number) {
			boolean result = true;
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					result = false;
					break;
				}
			}

			return result;
		}

		// Phương thức isPrime()
		public boolean IsPrime() {
			return this.IsPrime(this.myNumber);
		}

		// Phương thức PrintPrime
		public void PrintPrime() {
			for (int i = 1; i <= this.myNumber; i++) {
				if (this.IsPrime(i)) {
					System.out.println(i);
				}
			}
		}
	}

	/* Bài 02 */
	@Test
	public void Check_IsPrime() {
		// Arrange
		MyNumber number = new MyNumber(5);

		// Action
		boolean result = number.IsPrime();

		// Assertion
		Assert.assertEquals(true, result);
	}

	@Test
	public void Check_IsPrime_WithParam() {
		// Arrange
		MyNumber number = new MyNumber();

		// Action
		boolean result = number.IsPrime(10);

		// Assertion
		Assert.assertEquals(false, result);
	}
}
