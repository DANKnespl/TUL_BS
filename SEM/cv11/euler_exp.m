function [t,y] = euler_exp(f,a,b,y0,h)

    t=a:h:b;
    y=[];
    y(end+1)=y0;
    for i=1:length(t)
        y(end+1)=y(end)+h*f(t(i),y(end));
    end
    y=transpose(y);
end