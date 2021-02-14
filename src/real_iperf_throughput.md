# topo.py

## L1: h1-h2
@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.2 port 42594
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-24.0 sec  54.0 MBytes  18.9 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.2 port 42594 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-21.6 sec  54.0 MBytes  21.0 Mbits/sec

## L2: h2-h3
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.2 port 1234 connected with 10.0.0.3 port 48188
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-23.1 sec   105 MBytes  38.0 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.2 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.2, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.3 port 48188 connected with 10.0.0.2 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-21.0 sec   105 MBytes  41.8 Mbits/sec

## L3: h3-h10
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.10 port 1234 connected with 10.0.0.3 port 45720
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-23.0 sec  77.8 MBytes  28.4 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.10 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.10, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.3 port 45720 connected with 10.0.0.10 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.3 sec  77.8 MBytes  32.2 Mbits/sec

## L4: h2-h5
[ 40] local 10.0.0.2 port 1234 connected with 10.0.0.5 port 33900
[ 40]  0.0-23.0 sec  65.2 MBytes  23.8 Mbits/sec

------------------------------------------------------------
Client connecting to 10.0.0.2, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.5 port 33900 connected with 10.0.0.2 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.2 sec  65.2 MBytes  27.1 Mbits/sec

## L5: h3-h6
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.6 port 1234 connected with 10.0.0.3 port 45978
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-22.6 sec  64.2 MBytes  23.8 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.6 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.6, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.3 port 45978 connected with 10.0.0.6 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.0 sec  64.2 MBytes  26.9 Mbits/sec

## Q2: h1-h4
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.4 port 50392
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-25.9 sec  57.1 MBytes  18.5 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.4 port 50392 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-22.8 sec  57.1 MBytes  21.1 Mbits/sec

## Q4
### h1-h4
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.4 port 50528
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-22.2 sec  43.1 MBytes  16.3 Mbits/sec
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.4 port 50530
[ 40]  0.0-24.2 sec  53.5 MBytes  18.5 Mbits/sec
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.4 port 50534
[ 40]  0.0-24.0 sec  38.0 MBytes  13.3 Mbits/sec
[ 40] local 10.0.0.1 port 1234 connected with 10.0.0.4 port 50538
[ 40]  0.0-23.7 sec  41.9 MBytes  14.8 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.4 port 50528 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.1 sec  43.1 MBytes  18.0 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.4 port 50530 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-21.4 sec  53.5 MBytes  21.0 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.4 port 50534 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.7 sec  38.0 MBytes  15.4 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.1 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.1, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.4 port 50538 connected with 10.0.0.1 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.9 sec  41.9 MBytes  16.8 Mbits/sec

### h5-h6
root@mininet:~/cs640/cs640-a1/src# iperf -s -p 1234
------------------------------------------------------------
Server listening on TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 40] local 10.0.0.5 port 1234 connected with 10.0.0.6 port 46604
[ ID] Interval       Transfer     Bandwidth
[ 40]  0.0-23.1 sec  59.1 MBytes  21.4 Mbits/sec
[ 40] local 10.0.0.5 port 1234 connected with 10.0.0.6 port 46610
[ 40]  0.0-23.2 sec  52.9 MBytes  19.1 Mbits/sec
[ 40] local 10.0.0.5 port 1234 connected with 10.0.0.6 port 46614
[ 40]  0.0-23.2 sec  62.2 MBytes  22.5 Mbits/sec
[ 40] local 10.0.0.5 port 1234 connected with 10.0.0.6 port 46618
[ 40]  0.0-22.7 sec  61.6 MBytes  22.8 Mbits/sec

root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.5 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.5, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.6 port 46604 connected with 10.0.0.5 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.2 sec  59.1 MBytes  24.5 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.5 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.5, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.6 port 46610 connected with 10.0.0.5 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.9 sec  52.9 MBytes  21.3 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.5 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.5, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.6 port 46614 connected with 10.0.0.5 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.4 sec  62.2 MBytes  25.6 Mbits/sec
root@mininet:~/cs640/cs640-a1/src# iperf -c 10.0.0.5 -p 1234 -t 20
------------------------------------------------------------
Client connecting to 10.0.0.5, TCP port 1234
TCP window size: 85.3 KByte (default)
------------------------------------------------------------
[ 39] local 10.0.0.6 port 46618 connected with 10.0.0.5 port 1234
[ ID] Interval       Transfer     Bandwidth
[ 39]  0.0-20.0 sec  61.6 MBytes  25.8 Mbits/sec
