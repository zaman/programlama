b=input('Enter b value :');
if b < 10^3
	f=inline('x^2-2*b*x+1','x');
	d=(2*b)^2-4*1*1;
	root1 = b + sqrt(d)/2;
	root2 = b - sqrt(d)/2;
	fprintf("root1: %f\n root2:%f",root1,root2)
else
	disp("Big number error")
end
