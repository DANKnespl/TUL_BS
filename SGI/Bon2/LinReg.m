function [k] = LinReg(x,y)
    if size(x,2)>1
        x=transpose(x);
    end
    if size(y,2)>1
        y=transpose(y);
    end
    n=length(x);
    NM=[sum(x.*x), sum(x);sum(x), n];
    PS=[sum(x.*y);sum(y)];
    M=NM\PS;
    k=M(1);
%     q=M(2);
%     k=(n*sum(x*transpose(y))-sum(x)*sum(y))/(n*sum(x*transpose(x))-power(sum(x),2));
%     q=(sum(x*transpose(x))*sum(y)-sum(x)*sum(x*transpose(y)))/(n*sum(x*transpose(x))-power(sum(x),2));     


%     figure(3)
%     scatter(x,y);
%     hold on;
%     plot([x(1),x(end)],[y(1),y(end)]);
%     if k>0
%     plot([min(x),max(x)],[max(y(x==min(x))),min(y(x==max(x)))]);
%     
%     else
%     plot([min(x),max(x)],[min(y(x==min(x))),max(y(x==max(x)))]);   
%     end
%     fplot(@(m) k*m+q)
%     fplot(@(m) k*m+q)
    end

