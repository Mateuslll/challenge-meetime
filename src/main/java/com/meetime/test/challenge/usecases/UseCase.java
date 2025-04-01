package com.meetime.test.challenge.usecases;

public interface UseCase<I, O> {
  O execute(I input);
}
