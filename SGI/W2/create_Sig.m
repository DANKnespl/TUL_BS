function [y,t]=create_Sig(T,Fs,A,f,fi,M)
    Ts=1./Fs;
    t=0:Ts:T-Ts;
    y=[];
    for i=1:length(t)
        y(:,end+1)=A.*cos((2*pi)*t(i).*f+fi)+M;
    end
end