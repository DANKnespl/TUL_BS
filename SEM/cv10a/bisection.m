function [x,res,k] = bisection(f,a,b,tol,maxit)
    for i=(0:maxit)
        k=i;
        x=1/2*(a+b);
        if abs(f(x))<tol
            break;
        elseif f(x)*f(a)>0
            a=x;
        else
            b=x;
        end
    end
    res=abs(f(x));
end

