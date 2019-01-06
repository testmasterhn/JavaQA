package javaforqa;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class Lesson03 {
	/*
	 * Bài 01: Viết class vẫn là MyNumber với các đặc điểm - Thuộc tính: int[]
	 * arrNumber - lưu trữ một mảng các số nguyên - Phương thức: + MyNumber(int[]
	 * numbers) - Khởi tạo giá trị cho mảng số nguyên arrNumber + GetPrimeNumbers()
	 * - Trả ra một mảng các số nguyên tố từ mảng arrNumber + GetSummary() - Trả ra
	 * tổng các số nguyên tố tìm được + GetPrimeOrderList() - Trả ra list số nguyên
	 * tố đã được sắp xếp theo thứ tự tăng dần Bài 02: Viết Test method cho 2
	 * methods GetPrimeNumbers và GetSummary ở trên
	 */

	class MyNumber {
		// Thuộc tính
		public int[] arrNumber;

		// Method khởi tạo
		public MyNumber(int[] numbers) {
			this.arrNumber = numbers;
		}

		// Method get list of prime number
		public ArrayList GetPrimeNumbers() {
			// Khai báo một list để chứa các SNT tìm được
			ArrayList lstPrimeNumber = new ArrayList();

			// Lặp lần lượt các số trong mảng arrNumber
			for (int i = 0; i < arrNumber.length; i++) {
				int currentNumber = arrNumber[i];

				// Kiểm tra số currentNumber có phải SNT ko?
				// Bằng cách lặp từ 2->total -1, sau đó tìm ước thứ 3 củ số này
				// Nếu tồn tại thì không phải SNT
				// Nếu không tòn tại là SNT
				boolean isSNT = true;
				for (int k = 2; k < currentNumber; k++) {
					if (currentNumber % k == 0) {
						isSNT = false;
						break;
					}
				}

				if (isSNT == true) {
					lstPrimeNumber.add(currentNumber);
				}
			}
			return lstPrimeNumber;
		}

		// GetSummary()
		public int GetSummary() {
			// Lấy danh sách snt và lưu vào một arraylist để tính tổng
			ArrayList tmp = this.GetPrimeNumbers();

			// Khai báo một biến biến lưu trữ tổng
			int summary = 0;
			for (int i = 0; i < tmp.size(); i++) {
				int number = (int) tmp.get(i);
				// Java cu
				// int numbre = Integer.parseInt(tmp.get(i).toString());
				summary += number;
			}
			return summary;
		}

		// GetPrimeOrderList()
		public ArrayList GetPrimeOrderList() {
			// ArrayList lstNunberAfterSort = new ArrayList();
			ArrayList lstPrimeNumber = this.GetPrimeNumbers();

			for (int i = 0; i < lstPrimeNumber.size(); i++) {
				int primeNumber = (int) lstPrimeNumber.get(i);
				for (int j = i + 1; j < lstPrimeNumber.size(); j++) {
					int lookingforNumber = (int) lstPrimeNumber.get(j);

					if (lookingforNumber <= primeNumber) {
						// Exchange the number
						int tmp = primeNumber;
						lstPrimeNumber.set(i, lookingforNumber);
						lstPrimeNumber.set(j, tmp);
					}
				}
			}

			return lstPrimeNumber;
		}
	}

	// Test
	@Test
	public void Test_GetSummary() {
		// Arrange
		int[] originalNumber = { 2, 3, 4, 6, 7, 8, 9, 10 };

		MyNumber iamahero = new MyNumber(originalNumber);
		// Action

		int val = iamahero.GetSummary();

		// Asertion
		Assert.assertEquals(12, val);
	}

	@Test
	public void Test_GetPrimeOrderList() {
		// Arrange
		int[] originalNumber = { 2, 7, 4, 6, 3, 8, 9, 10 };
		
		MyNumber iamahero = new MyNumber(originalNumber);
		
		// Action
		ArrayList val = iamahero.GetPrimeOrderList();
		
		for (int i = 0; i < val.size(); i++) {
			System.out.println(val.get(i));
		}
	}
}
