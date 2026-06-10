clc;clear;clf;
load("velocity.mat", "-ascii");
velocity(2,:)=velocity(2,:)./3.6;
f1=figure(1);
yyaxis("left");
plot(velocity(1,:),velocity(2,:)*3.6);
hold on;
ylabel("v [km/h]");
yyaxis("right");
[a z]=accel(velocity);
plot(velocity(1,:),accel(velocity));
scatter(z,z*0,"Marker","o");
yline(0,"LineStyle","--");
legend("velocity","acceleration","a(x)=0","y=0");
xlabel("t [s]");
ylabel("a [m/s^2]")
saveas(f1,"graph_acceleration.png");