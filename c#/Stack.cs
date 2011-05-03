using System;
namespace Proje1
{
		class Stack
	{
		int max_length;
		string[] yigit;

		public Stack (int max_value)
		{
			max_length = max_value;
			yigit = new string[max_value];
		}

		public bool Control()
		{
			return Size() == max_length;
		}

		public bool isEmpty()
		{
			return yigit[0] == null;
		}

		public void Push(string item)
		{
			int p_size = Size();
			if (Control())
				Console.WriteLine("Yigit Dolu! Ekleme Yapamazsınız ");
			else
				yigit[p_size] = item;
		}
		public string Pop()
		{
			int p_size = Size();
			string svalue;
			if (isEmpty()) 
				return null;
			else 
				svalue = yigit[p_size - 1];
				yigit[p_size -1 ] = null;
				return svalue;
		}		
		public string Peek()
		{
			if (Size() == 0)
				return null;
			else
				return yigit[Size() - 1];
		}
		public int Size()
		{
			int i = 0;
			while (yigit[i] != null)
				++i;
			return i;
		}
	}

}
