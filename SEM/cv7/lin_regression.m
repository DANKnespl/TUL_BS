function [k,q] = lin_regression(x,y)
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
    q=M(2);
    %k=(n*sum(x*transpose(y))-sum(x)*sum(y))/(n*sum(x*transpose(x))-power(sum(x),2))
    %q=(sum(x*transpose(x))*sum(y)-sum(x)*sum(x*transpose(y)))/(n*sum(x*transpose(x))-power(sum(x),2))
end