package com.gymme.data.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gymme.data.data.LocalExercise;
import java.lang.Exception;
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
public final class WorksheetExercisesDao_Impl implements WorksheetExercisesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocalExercise> __insertionAdapterOfLocalExercise;

  public WorksheetExercisesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalExercise = new EntityInsertionAdapter<LocalExercise>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `worksheet_exercises` (`id`,`description`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalExercise value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
      }
    };
  }

  @Override
  public Object insert(final List<LocalExercise> exercises, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocalExercise.insert(exercises);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object get(final Continuation<? super List<LocalExercise>> p0) {
    final String _sql = "SELECT * FROM worksheet_exercises";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<LocalExercise>>() {
      @Override
      public List<LocalExercise> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<LocalExercise> _result = new ArrayList<LocalExercise>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocalExercise _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item = new LocalExercise(_tmpId,_tmpDescription);
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
