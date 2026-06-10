function [x,res,k] = newton(f,fp,x0,tol,maxit)
    x=x0;
    k=0;
    for i=1:maxit
        if abs(f(x))<tol
            break;
        end
        k=i;
        x=x-f(x)/fp(x); 
    end
    res=abs(f(x));
end