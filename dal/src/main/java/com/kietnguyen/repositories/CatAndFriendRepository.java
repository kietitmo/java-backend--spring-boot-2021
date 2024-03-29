package com.kietnguyen.repositories;

import com.kietnguyen.models.Cat;
import com.kietnguyen.models.CatAndFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CatAndFriendRepository extends JpaRepository<CatAndFriend, Integer> {

    @Query(value = "SELECT caf.friend FROM CatAndFriend caf WHERE caf.cat.id = :id")
    public List<Cat> getFriendListOfCat(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM CatAndFriend caf WHERE (caf.cat.id = :id AND caf.friend.id = :idFriend) OR (caf.cat.id = :idFriend AND caf.friend.id = :id)")
    public void deleteFriendOfCat(@Param("id") Integer id, @Param("idFriend")Integer idFriend);

    @Modifying
    @Query("DELETE FROM CatAndFriend caf WHERE (caf.cat.id = :id) OR (caf.friend.id = :id)")
    public void deleteAllFriendOfCat(@Param("id") Integer id);
}
