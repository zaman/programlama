using System;
using System.IO;
using System.Text;

namespace Proje1
{
	class FileOperation
	{
		public static string Read(string NewFile)
		{
			string reading = "";
			StreamReader read = new StreamReader(NewFile);
			reading = read.ReadToEnd();
			read.Close();
			return reading;
		}

		public static void Write(string NewFile,string Txt)
		{
			StreamWriter write = new StreamWriter(NewFile);
			write.WriteLine(Txt);
			write.Close();
		}
		public static void Append(string ExFile,string Txt)
		{
			StreamWriter file;
			file = File.AppendText(ExFile);
			file.WriteLine(Txt);
			file.Close();
		}
	}
}
