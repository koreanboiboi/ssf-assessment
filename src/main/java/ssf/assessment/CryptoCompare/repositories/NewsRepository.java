package ssf.assessment.CryptoCompare.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;


@Repository
public class NewsRepository {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public Object get(String id){
        ValueOperations<String,Object> valueops = redisTemplate.opsForValue();

        return valueops.get(id);
    }


}
