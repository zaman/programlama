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
			int i;
			i = Size();
			return i == max_length;
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
		public void Pop()
		{
			int p_size = Size();
			if (isEmpty()) 
				Console.WriteLine("Yigit Bos!");
			else 
				yigit[p_size - 1] = null;
		}		
		public string Peek()
		{
			int p_size = Size();
			return yigit[p_size - 1];
		}
		public int Size()
		{
			int i = 0;
			while (yigit[i] != null)
			{
				++i;
			}
			return i;
		}
	}
}