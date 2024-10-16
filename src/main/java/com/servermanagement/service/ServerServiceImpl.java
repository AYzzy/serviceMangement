package com.servermanagement.service;

import com.servermanagement.data.Repository.ServerRepo;
import com.servermanagement.data.model.Server;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static com.servermanagement.data.model.Status.SERVER_DOWN;
import static com.servermanagement.data.model.Status.SERVER_UP;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService{

    private final ServerRepo repo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return repo.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server Ip: {}", ipAddress);
        Server server = repo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setIpAddress(String.valueOf(address.isReachable(100000)? SERVER_UP : SERVER_DOWN));
        repo.save(server);
        return server;
    }

    private String setServerImageUrl() {
        return null;
    }
}
