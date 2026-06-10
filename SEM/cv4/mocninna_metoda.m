function [vec, lambda] = mocninna_metoda(A, y0, tol, maxit)
    yk1=y0;
    lambda=NaN;
    lambda0=NaN;
    bool=true;
    i=0;
    while(bool)
        yk0=yk1;
        yk1=A*yk0;
        lambda0=lambda;
        lambda=(transpose(yk0)*yk1)/(transpose(yk0)*yk0);
        i=i+1;
    if(i>maxit || abs(lambda-lambda0)<tol)
        bool=false;
    end
    end
    vec=yk1/norm(yk1);
end