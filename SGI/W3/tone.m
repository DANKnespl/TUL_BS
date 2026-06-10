function sig=tone(f,Fs,T)
 t=0:1/Fs:T-1/Fs;
 sig=cos(2*pi*f*t)
 % plot(t,sig);
 %sound(sig,Fs);
end