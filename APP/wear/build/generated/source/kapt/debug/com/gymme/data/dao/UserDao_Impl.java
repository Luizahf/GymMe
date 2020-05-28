package com.gymme.data.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gymme.data.data.LocalUser;
import java.lang.Character;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocalUser> __insertionAdapterOfLocalUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalUser = new EntityInsertionAdapter<LocalUser>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users` (`Id`,`Name`,`Height`,`Weight`,`Gender`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalUser value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getHeight() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getHeight());
        }
        if (value.getWeight() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getWeight());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getGender());
        }
      }
    };
  }

  @Override
  public Object insert(final LocalUser user, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocalUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object get(final Continuation<? super List<LocalUser>> p0) {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<LocalUser>>() {
      @Override
      public List<LocalUser> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "Name");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "Height");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "Weight");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "Gender");
          final List<LocalUser> _result = new ArrayList<LocalUser>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalUser _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final Integer _tmpHeight;
            if (_cursor.isNull(_cursorIndexOfHeight)) {
              _tmpHeight = null;
            } else {
              _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
            }
            final Integer _tmpWeight;
            if (_cursor.isNull(_cursorIndexOfWeight)) {
              _tmpWeight = null;
            } else {
              _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            }
            final Character _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = (char) _cursor.getInt(_cursorIndexOfGender);
            }
            _item = new LocalUser(_tmpId,_tmpName,_tmpHeight,_tmpWeight,_tmpGender);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
