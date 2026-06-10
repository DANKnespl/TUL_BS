clc;clear;cla;
load("data0.mat", '-ascii');
load("data1.mat", '-ascii');
load("data2.mat", '-ascii');
load("data3.mat", '-ascii');
v=-5:0.05:5;

f0=figure(1);
clf;
x=data0(:,1);
y=data0(:,2);
plot(v,lagrange(x,y,v),"Color","black"); %stejný graf jako spline
hold on;
plot(v,interp1(x,y,v,'linear'),"Color","red");
plot(v,interp1(x,y,v,'spline'),"Color","green");
plot(v,interp1(x,y,v,'pchip'),"Color","blue");
plot(v,interp1(x,y,v,'makima'),"Color","magenta");
scatter(x,y,"black");

legend("lagrange","linear","spline","pchip","makima","data");
xlabel("x");
ylabel("f(x)");

f1=figure(2);
clf;
x=data1(:,1);
y=data1(:,2);
plot(v,lagrange(x,y,v),"Color","black"); %stejný graf jako spline
hold on;
plot(v,interp1(x,y,v,'linear'),"Color","red");
plot(v,interp1(x,y,v,'spline'),"Color","green");
plot(v,interp1(x,y,v,'pchip'),"Color","blue");
plot(v,interp1(x,y,v,'makima'),"Color","magenta");
scatter(x,y,"black");

legend("lagrange","linear","spline","pchip","makima","data");
xlabel("x");
ylabel("f(x)");

f2=figure(3);
clf;
x=data2(:,1);
y=data2(:,2);
%plot(v,lagrange(x,y,v),"Color","black"); %stejný graf jako spline
plot(v,interp1(x,y,v,'linear'),"Color","red");
hold on;
plot(v,interp1(x,y,v,'spline'),"Color","green");
plot(v,interp1(x,y,v,'pchip'),"Color","blue");
plot(v,interp1(x,y,v,'makima'),"Color","magenta");
scatter(x,y,"black");

legend("linear","spline","pchip","makima","data");
xlabel("x");
ylabel("f(x)");

f3=figure(4);
clf;
x=data3(:,1);
y=data3(:,2);
plot(v,interp1(x,y,v,'linear'),"Color","red");
hold on;
plot(v,interp1(x,y,v,'spline'),"Color","green");
plot(v,interp1(x,y,v,'pchip'),"Color","blue");
plot(v,interp1(x,y,v,'makima'),"Color","magenta");
scatter(x,y,"black");

legend("linear","spline","pchip","makima","data");
xlabel("x");
ylabel("f(x)");

saveas(f0,"graph_data0.png");
saveas(f1,"graph_data1.png");
saveas(f2,"graph_data2.png");
saveas(f3,"graph_data3.png");