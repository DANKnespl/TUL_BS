clear;clc;clf;
x1=(-25:0.1:25);
x1(find(x1==1))=NaN;
x2=(-10:0.1:10);
x3=(-1:0.1:2);

syms Sx
    f=atan((Sx+1)./(Sx-1));
        a1r=limit(f, Sx, 1, "right")
        a1l=limit(f, Sx, 1, "left")
        a1=limit(f, Sx, 1)
        b1=limit(f, Sx, Inf)
        c1=limit(f, Sx, -Inf)
    g=Sx/(sqrt(Sx.^2-1));
        a2r=limit(g, Sx, 1, "right")
        a2l=limit(g, Sx, 1, "left")
        b2=limit(g, Sx, Inf)
        c2=limit(g, Sx, -Inf)
    h=Sx.^Sx;
        a3r=limit(h, Sx, 1, "right")
        a3l=limit(h, Sx, 1, "left")
        b3=limit(h, Sx, Inf)
        c3=limit(h, Sx, -Inf)
syms

y1=atan((x1+1)./(x1-1));
y2=x2./(sqrt(x2.^2-1));
y3=x3.^x3;

y1(imag(y1) ~= 0) = NaN;
y2(imag(y2) ~= 0) = NaN;
y3(imag(y3) ~= 0) = NaN;

fig1=figure(1);
plot(x1,y1);
xlabel("x");
ylabel("f(x)");

fig2=figure(2);
plot(x2,y2);
xlabel("x");
ylabel("g(x)");

fig3=figure(3);
plot(x3,y3);
xlabel("x");
ylabel("h(x)");


set(fig1,'Units','Inches');
pos = get(fig1,'Position');
set(fig1,'PaperPositionMode','Auto','PaperUnits','Inches','PaperSize',[pos(3), pos(4)])
print(fig1,'cv6f1','-dpdf','-r0')

set(fig2,'Units','Inches');
pos = get(fig2,'Position');
set(fig2,'PaperPositionMode','Auto','PaperUnits','Inches','PaperSize',[pos(3), pos(4)])
print(fig2,'cv6f2','-dpdf','-r0')

set(fig3,'Units','Inches');
pos = get(fig3,'Position');
set(fig3,'PaperPositionMode','Auto','PaperUnits','Inches','PaperSize',[pos(3), pos(4)])
print(fig3,'cv6f3','-dpdf','-r0')