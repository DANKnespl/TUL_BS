function [x,res,k] = newton_diff(f,x0,x1,tol,maxit)
    for i=1:maxit
        if abs(f(x1))<tol
            break;
        end
        k=i;
        tmp=x1;
        x1=x1-f(x1)*((x1-x0)/(f(x1)-f(x0)));
        x0=tmp;
    end
    x=x1;
    res=abs(f(x));
end