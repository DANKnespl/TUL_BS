function t = pul(x,y,k)
if k>0
    tmp1x=(x(1)+x(3))/2;
    tmp1y=(y(1)+y(3))/2;
    tmp2x=(x(2)+x(4))/2;
    tmp2y=(y(2)+y(4))/2;
else
    tmp1x=(x(1)+x(4))/2;
    tmp1y=(y(1)+y(4))/2;
    tmp2x=(x(2)+x(3))/2;
    tmp2y=(y(2)+y(3))/2;
end
    t=rad2deg(atan(LinReg([tmp1x, tmp2x],[tmp1y,tmp2y])));
end